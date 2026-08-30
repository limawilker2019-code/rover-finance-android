import React from 'react'
import ReactDOM from 'react-dom/client'

function App() {
  return (
    <div style={{ color: '#fff', padding: '20px', textAlign: 'center' }}>
      <h1>🚀 Rover Finance</h1>
      <p>Seu app de controle de fluxo de caixa está pronto!</p>
      <p style={{ fontSize: '12px', color: '#888' }}>Versão Android 1.0.0</p>
    </div>
  )
}

ReactDOM.createRoot(document.getElementById('root')).render(<App />)
