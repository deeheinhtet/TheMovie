//
//  RatingVIew.swift
//  iosApp
//
//  Created by Hein Htet on 3/20/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct RatingView: View {
    
    var rating : Float = 0
    var ratingLabel : String = ""
    
    var body: some View {
        CircularProgressView(progress: CGFloat(rating),color: getRatingRingColor(rating: rating
                                                                                     ))
            .padding(4)
        Text(ratingLabel)
            .font(.system(size: 8))
            .foregroundColor(.white)
    }
    
    func getRatingRingColor(rating :Float) -> Color {
        if rating >= 0.6 {
            return .green
        }else {
            return .yellow
        }
    }
}
