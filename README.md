# 🚀 Rover Finance - Android App

> Aplicativo de controle de fluxo de caixa pessoal convertido para Android usando Capacitor

## 📋 Requisitos

- **Node.js** 16+ ([Download](https://nodejs.org))
- **Android Studio** ([Download](https://developer.android.com/studio))
- **Java Development Kit (JDK)** 11+ (instalado com Android Studio)
- **Git**

## ⚡ Instalação Rápida

### 1️⃣ Clonar o Repositório

```bash
git clone https://github.com/limawilker2019-code/rover-finance-android.git
cd rover-finance-android
```

### 2️⃣ Instalar Dependências

```bash
npm install
```

### 3️⃣ Compilar Projeto Web

```bash
npm run build
```

### 4️⃣ Adicionar Plataforma Android (primeira vez)

```bash
npm run cap:add:android
```

### 5️⃣ Sincronizar com Android

```bash
npm run cap:sync
```

### 6️⃣ Abrir no Android Studio

```bash
npm run cap:open:android
```

## 🏗️ Build para Android

### Gerar APK de Debug

No Android Studio:
1. Menu: `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
2. Aguarde a compilação
3. O arquivo estará em: `android/app/release/app-release.apk`

### Instalar no Dispositivo

```bash
# Conecte seu Android via USB (com debug ativado)
adb install android/app/release/app-release.apk
```

## 📁 Estrutura do Projeto

```
rover-finance-android/
├── src/
│   ├── main.jsx              # Componente principal React
│   └── capacitor-init.js     # Inicialização Capacitor
├── android/                  # Projeto Android Studio
├── dist/                     # Build web (gerado)
├── index.html               # HTML principal
├── capacitor.config.json    # Config Capacitor
├── vite.config.js           # Config Vite
├── package.json             # Dependências NPM
└── README.md               # Este arquivo
```

## 🛠️ Comandos Disponíveis

| Comando | Descrição |
|---------|----------|
| `npm run dev` | Iniciar servidor de desenvolvimento (web) |
| `npm run build` | Compilar projeto web para produção |
| `npm run cap:sync` | Sincronizar arquivos com Android |
| `npm run cap:open:android` | Abrir projeto no Android Studio |
| `npm run android:build` | Build completo para Android |

## 🚀 Publicar na Google Play Store

1. **Criar conta de desenvolvedor** - [Google Play Console](https://play.google.com/console) (R$ 25,00)
2. **Gerar APK/AAB de release**
3. **Criar Keystore**:
   ```bash
   keytool -genkey -v -keystore my-release-key.jks -keyalg RSA -keysize 2048 -validity 10000
   ```
4. **Configurar assinatura** em `android/app/build.gradle`
5. **Fazer upload** na Play Console
6. **Submeter para análise**

## 🔧 Troubleshooting

### "command not found: adb"
```bash
# Configure PATH do Android SDK
# No macOS/Linux adicione ao ~/.bashrc ou ~/.zshrc:
export ANDROID_HOME=$HOME/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/platform-tools
```

### "Gradle build failed"
```bash
# Limpe e reconfigure
cd android
./gradlew clean
cd ..
npm run cap:sync
```

### App não aparece em "Instalar apps desconhecidos"
- Vá em Configurações → Segurança → Instalar apps desconhecidos
- Ative para o seu gerenciador de arquivos/navegador

## 📦 Download do APK

**Arquivo APK compilado:** [rover-finance.apk](releases/)

> 📌 **Nota:** Para baixar o APK compilado, acesse a seção "Releases" deste repositório

## 📞 Suporte

Tem dúvidas? Abra uma [issue](issues) ou consulte a [documentação do Capacitor](https://capacitorjs.com/docs/android)

## 📄 Licença

MIT - Veja LICENSE para detalhes

---

**Desenvolvido com ❤️ para controle financeiro pessoal**
