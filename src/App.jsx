import React, { useState, useEffect } from 'react'
import StorageService from './services/StorageService'
import Dashboard from './pages/Dashboard'
import Transactions from './pages/Transactions'
import AddTransaction from './pages/AddTransaction'
import Settings from './pages/Settings'
import './styles/App.css'

export default function App() {
  const [currentTab, setCurrentTab] = useState('dashboard')
  const [transactions, setTransactions] = useState([])
  const storage = new StorageService()

  useEffect(() => {
    loadTransactions()
  }, [])

  async function loadTransactions() {
    const data = await storage.getTransactions()
    setTransactions(data)
  }

  async function handleAddTransaction(transaction) {
    await storage.addTransaction(transaction)
    await loadTransactions()
  }

  async function handleDeleteTransaction(id) {
    await storage.deleteTransaction(id)
    await loadTransactions()
  }

  const tabs = [
    { id: 'dashboard', label: 'Dashboard', icon: '📊' },
    { id: 'transactions', label: 'Transações', icon: '📝' },
    { id: 'add', label: 'Adicionar', icon: '➕' },
    { id: 'settings', label: 'Configurações', icon: '⚙️' }
  ]

  return (
    <div className="app">
      <header className="app-header">
        <h1>🚀 Rover Finance</h1>
        <p>Controle de fluxo de caixa pessoal</p>
      </header>

      <nav className="app-nav">
        {tabs.map(tab => (
          <button
            key={tab.id}
            className={`nav-btn ${currentTab === tab.id ? 'active' : ''}`}
            onClick={() => setCurrentTab(tab.id)}
          >
            <span>{tab.icon}</span>
            <span>{tab.label}</span>
          </button>
        ))}
      </nav>

      <main className="app-content">
        {currentTab === 'dashboard' && <Dashboard transactions={transactions} />}
        {currentTab === 'transactions' && (
          <Transactions
            transactions={transactions}
            onDelete={handleDeleteTransaction}
          />
        )}
        {currentTab === 'add' && <AddTransaction onAdd={handleAddTransaction} />}
        {currentTab === 'settings' && (
          <Settings
            transactions={transactions}
            onClear={() => {
              storage.clearAll()
              setTransactions([])
            }}
          />
        )}
      </main>
    </div>
  )
}
