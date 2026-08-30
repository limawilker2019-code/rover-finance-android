# ⚡ Início Rápido - Rover Finance Android

## O que você precisa fazer:

### 1. Instale as ferramentas
```bash
# Node.js: https://nodejs.org (versão 16+)
# Android Studio: https://developer.android.com/studio
# Git: https://git-scm.com
```

### 2. Clone e configure
```bash
git clone https://github.com/limawilker2019-code/rover-finance-android.git
cd rover-finance-android
npm install
```

### 3. Compile
```bash
npm run build
npm run cap:add:android
npm run cap:sync
npm run cap:open:android
```

### 4. No Android Studio
- Menu: `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
- Aguarde terminar
- APK pronto em: `android/app/release/app-release.apk`

### 5. Instale no seu Android
```bash
adb install android/app/release/app-release.apk
```

## ✅ Pronto!
Seu app Rover Finance está instalado e pronto para usar! 🎉

---

**Precisa de ajuda?** Veja o [README completo](README.md)
