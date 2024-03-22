import SwiftUI
import Shared



struct ContentView: View {
    
    var body: some View {
        NavigationView {
            HomeScreen(viewModel: .init())
        }
    }
}

