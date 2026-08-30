import { App } from '@capacitor/app'
import { SplashScreen } from '@capacitor/splash-screen'

// Ocultar splash screen após app estar pronto
setTimeout(() => {
  SplashScreen.hide().catch(() => {})
}, 2000)

// Lidar com botão back do Android
App.addListener('backButton', ({ canGoBack }) => {
  if (!canGoBack) {
    App.exitApp()
  } else {
    window.history.back()
  }
})
