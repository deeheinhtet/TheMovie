import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    init() {
        KoinSetupKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
            ContentView()
		}
	}
}
