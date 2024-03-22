//
//  CircularProgressBar.swift
//  iosApp
//
//  Created by Hein Htet on 3/18/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct CircularProgressView: View {
    let progress: CGFloat
    let color : Color
    
    var body: some View {
        ZStack {
            // Background for the progress bar
            Circle()
                .stroke(lineWidth: 2)
                .opacity(0.1)
                .foregroundColor(color)
            
            // Foreground or the actual progress bar
            Circle()
                .trim(from: 0.0, to: min(progress, 1.0))
                .stroke(style: StrokeStyle(lineWidth: 2, lineCap: .round, lineJoin: .round))
                .foregroundColor(color)
                .rotationEffect(Angle(degrees: 270.0))
                .animation(.linear, value: progress)
        }
    }
}
#Preview {
    CircularProgressView(progress: 1, color: .green)
}
