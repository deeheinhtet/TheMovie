//
//  MovieItemView.swift
//  iosApp
//
//  Created by Hein Htet on 3/17/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared

struct MovieItemView : View {
    @State var item:MovieItemDisplay
    var body:some View {
        VStack(alignment : .leading){
            ZStack(alignment: .bottomLeading) {
                AsyncImage(url: URL(string: item.imageUrl)) { image in
                    image
                        .resizable()
                        .aspectRatio(contentMode: .fill)
                } placeholder: {
                    ProgressView()
                }.frame(height: 240)
                    .cornerRadius(8)
                ZStack{
                    RatingView(rating: item.rating,ratingLabel: item.ratingLabel)
                    
                }
                .frame(width : 40,height: 40)
                .background(.black)
                .cornerRadius(20)
                .alignmentGuide(.bottom, computeValue: { dimension in
                    20
                }).alignmentGuide(.leading, computeValue: { dimension in
                    -16
                })
            }
            Text(item.title)
                .font(.system(.caption))
                .fontWeight(.bold)
                .lineLimit(1)
                .truncationMode(.tail)
            Text(item.releasedDate)
                .font(.system(.caption2))
                .fontWeight(.medium)
                .foregroundStyle(Color.gray)
        }
        .frame(width: 150,height: 300)
    }
    
    func getRatingRingColor(rating :Float) -> Color {
        if rating >= 0.6 {
            return .green
        }else {
            return .yellow
        }
    }
    
}
