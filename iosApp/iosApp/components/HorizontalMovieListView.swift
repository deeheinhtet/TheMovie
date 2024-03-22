//
//  HorizontalMovieListView.swift
//  iosApp
//
//  Created by Hein Htet on 3/17/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared

struct HorizontalMovieListView: View {
    
    @Binding var items : [MovieItemDisplay]
    @State var title = ""
    var onItemTapAction: ((_ item : MovieItemDisplay) -> Void?)
    
    
    var body: some View {
        VStack(alignment: .leading){
            Text(title).padding(.leading,12)
                .padding(.top,16)
                .font(.system(.headline))
            ScrollView(.horizontal,showsIndicators: false){
                HStack(spacing: 28){
                    ForEach(items, id: \.id) { item in
                        NavigationLink(destination :  MovieDetailsScreen(viewModel: .init(),movieId: String(item.id))) {
                            MovieItemView(item: item)
                        }
                    }
                }.padding(.horizontal,16)
            }
        }
    }
}

extension HorizontalMovieListView {
    func onItemTapAction(_ handler: @escaping (_ item : MovieItemDisplay) -> Void?) -> HorizontalMovieListView {
        var new = self
        new.onItemTapAction = handler
        return new
    }
}
