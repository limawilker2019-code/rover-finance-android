# Rover Finance - Notification Listener feature

Este branch adiciona um NotificationListener em Java que captura notificações do sistema, extrai valores monetários e envia um payload JSON para a WebView do app. A página HTML (assets/index.html) possui um agente IA local (heurísticas JS) que tenta classificar a notificação como despesa ou receita e preencher os campos do formulário.

Como testar
1. Instale a versão do branch feat/notification-listener no dispositivo.
2. Ative o acesso a notificações: Settings > Apps & notifications > Special app access > Notification access, e habilite Rover Finance.
3. Envie notificações de teste (por exemplo notificações de apps de pagamento ou via adb) e observe o preenchimento automático no WebView.

Privacidade
- Nada é enviado para servidores externos — todo o processamento é local no dispositivo e na página WebView.

Observações
- O package usado neste patch é com.roverfinance.app. Se seu projeto usa outro package, atualize os paths de arquivo e o AndroidManifest conforme necessário.
- Se já existir uma MainActivity no projeto, este patch cria uma MainActivity nova; você pode mesclar o receiver no seu código existente para evitar duplicação.
