//
//  MovieDetailsScreen.swift
//  iosApp
//
//  Created by Hein Htet on 3/17/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared


extension MovieDetailsScreen {
    
    @MainActor
    class MovieDetailsViewModelWrapper : ObservableObject {
        
        @Published var movieDetails : MovieDetailsDisplay? = nil
        @Published var isLoading : Bool = false
    let viewModel = ViewModelInjector().movieDetailsViewModel
        
        init() {
            movieDetails = viewModel.outputs.movieDetails.value
            isLoading = viewModel.outputs.loading.value.boolValue
        }
        
        func onGetMovieDetails(id:String){
            viewModel.inputs.onGetMovieDetails(id: id)
        }
        
        
        func startObserving() {
            Task {
                for await _movieDetails in viewModel.outputs.movieDetails {
                    self.movieDetails = _movieDetails
                }
            }
        }
        
        func cancel() {
            viewModel.inputs.cancel()
            movieDetails = nil
        }
    }
}

struct MovieDetailsScreen: View {
    
    @ObservedObject private(set) var viewModel : MovieDetailsViewModelWrapper
    
    var movieId :String = ""
    
    var body: some View {
        ZStack {
            ScrollView(.vertical) {
                if viewModel.movieDetails != nil {
                    let details = viewModel.movieDetails!
                    VStack(alignment : .leading){
                        ZStack(alignment: .topLeading) {
                            Color.clear
                            AsyncImage(url: URL(string: details.backdropImageUrl)) { image in
                                image
                                    .resizable()
                                    .aspectRatio(contentMode: .fill)
                            } placeholder: {
                                ProgressView()
                            }.frame(height: 250)

                            HStack {
                                ZStack(alignment : .bottomLeading){
                                    AsyncImage(url: URL(string: details.posterImageUrl)) { image in
                                        image.resizable()
                                            .aspectRatio(contentMode: .fit)
                                    } placeholder: {
                                        ProgressView()
                                        
                                    }.frame(width: 150,height:250).cornerRadius(20)
                                    
                                    ZStack(alignment : .center){
                                        RatingView(rating: details.rating,ratingLabel: details.ratingLabel)
                                        
                                    }
                                    .frame(width : 40,height: 40)
                                    .background(.black)
                                    .cornerRadius(20)
                                    .alignmentGuide(.bottom, computeValue: { dimension in
                                        32
                                    }).alignmentGuide(.leading, computeValue: { dimension in
                                        -16
                                    })
                                }.frame(width: 150,height: 350)
                                VStack(alignment : .leading) {
                                    Text(details.title)
                                        .padding(.leading, 16)
                                        .font(.caption)
                                    
                                    Text(details.releasedDate)
                                        .padding(.leading, 16)
                                        .font(.caption2)
                                        .foregroundStyle(Color.white)
                                    
                                    Text("•" + details.genres)
                                        .padding(.leading, 16)
                                        .font(.caption2)
                                        .foregroundStyle(Color.green)
                                    
                                    Text("•" + details.duration)
                                        .padding(.leading, 16)
                                        .font(.caption2)
                                        .foregroundStyle(Color.gray)
                                    
                                    
                                }.padding(.top,24 )
                                
                            }.alignmentGuide(.top, computeValue: { dimension in
                                -125
                            }).alignmentGuide(.leading, computeValue: { dimension in
                                -42
                            })
                        }.frame(height: 400)
                      
                        
                        Text(details.description_)
                            .padding(.horizontal, 42)
                            .font(.caption)
                            .foregroundColor(.white)
                    }
                }else {
                    VStack{}
                }
                if viewModel.isLoading {
                    ProgressView()
                }else{
                    VStack{}
                }
            }.onAppear(perform: {
                viewModel.onGetMovieDetails(id: movieId)
                viewModel.startObserving()
            }).onDisappear(perform: {
                viewModel.cancel()
            })
        }.navigationBarBackButtonTitleHidden()
    }
}

#Preview {
    MovieDetailsScreen(viewModel: .init())
}
