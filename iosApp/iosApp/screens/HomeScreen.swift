//
//  HomeScreen.swift
//  iosApp
//
//  Created by Hein Htet on 3/17/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared


extension HomeScreen {
    
    @MainActor
    class  HomeViewModelWrapper : ObservableObject {
        @Published var popularMovies : [MovieItemDisplay]
        @Published var trendingMovies : [MovieItemDisplay]
        @Published var nowPlayingMovies : [MovieItemDisplay]
        @Published var upcomingMovies : [MovieItemDisplay]
        @Published var isLoading : Bool
        
        
        
        let viewModel : HomeViewModel
        
        init() {
            viewModel = ViewModelInjector().homeViewModel
            popularMovies = viewModel.outputs.popularMovies.value
            trendingMovies = viewModel.outputs.trendingMovies.value
            nowPlayingMovies = viewModel.outputs.nowPlayingMovies.value
            upcomingMovies = viewModel.outputs.upcomingMovies.value
            isLoading = viewModel.outputs.loading.value.boolValue
        }
        
        
        func startObserving(){
            Task {
                for await _popularMovies in viewModel.outputs.popularMovies {
                    self.popularMovies = _popularMovies
                }
            }
            Task {
                for await _trendingMovies in viewModel.outputs.trendingMovies {
                    self.trendingMovies = _trendingMovies
                }
            }
            Task {
                for await _nowPlayingMovies in viewModel.outputs.nowPlayingMovies {
                    self.nowPlayingMovies = _nowPlayingMovies
                }
            }
            Task {
                for await _upcomingMovies in viewModel.outputs.upcomingMovies {
                    self.upcomingMovies = _upcomingMovies
                }
            }
            Task {
                for await _isLoading in viewModel.outputs.loading {
                    self.isLoading = _isLoading.boolValue
                }
            }
        }
        
        func cancel() {
            viewModel.inputs.cancel()
        }
    }
}

struct HomeScreen: View {
    @ObservedObject private(set) var viewModel :HomeViewModelWrapper
    @State private var movieDetailsItem : MovieItemDisplay? = nil
    
    var body: some View {
        ZStack{
            ScrollView(.vertical){
                VStack {
                    if !viewModel.trendingMovies.isEmpty {
                        HorizontalMovieListView(items: $viewModel.trendingMovies,title: "Trending Movies"){ item in
                        }
                    }
                    if !viewModel.nowPlayingMovies.isEmpty {
                        HorizontalMovieListView(items: $viewModel.nowPlayingMovies,title: "Now Playing Movies"){item in }
                    }
                    if !viewModel.popularMovies.isEmpty {
                        HorizontalMovieListView(items: $viewModel.popularMovies,title: "Popular Movies"){ item in
                            
                        }.padding(.top,8)
                    }
                    if !viewModel.upcomingMovies.isEmpty {
                        HorizontalMovieListView(items: $viewModel.upcomingMovies,title: "Upcoming Movies"){item in }
                            .padding(.top,8)
                    }
                }
            }
            if viewModel.isLoading {
                ProgressView()
            }else{
                VStack{}
            }
        }.navigationTitle("The Movie")
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            .onAppear(perform: {
                viewModel.startObserving()
            }).onDisappear(perform: {
                viewModel.cancel()
            })
    }
}

#Preview {
    HomeScreen(viewModel:.init())
}
