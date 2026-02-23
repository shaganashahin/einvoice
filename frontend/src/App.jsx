import { useEffect, useState } from 'react'
import CustomerForm from './components/CustomerForm'
import CustomerTable from './components/CustomerTable'
import { createCustomer, getCustomers, scheduleMeeting, sendAgreement, signAgreement } from './api/client'

export default function App() {
  const [customers, setCustomers] = useState([])
  const [message, setMessage] = useState('')

  async function loadCustomers() {
    const data = await getCustomers()
    setCustomers(Array.isArray(data) ? data : [])
  }

  useEffect(() => {
    loadCustomers()
  }, [])

  async function handleCreate(payload) {
    await createCustomer(payload)
    setMessage('Customer added successfully.')
    await loadCustomers()
  }

  async function handleMeeting(customerId) {
    const scheduledAt = prompt('Enter date/time (YYYY-MM-DDTHH:mm):')
    const agenda = prompt('Meeting agenda:')
    if (!scheduledAt || !agenda) return
    await scheduleMeeting(customerId, { scheduledAt, agenda })
    setMessage('Meeting scheduled.')
  }

  async function handleAgreement(customerId, type) {
    const agreement = await sendAgreement(customerId, type)
    setMessage(`Agreement sent. Signing link: ${agreement.signingLink}`)
  }

  async function handleQuickSign() {
    const token = prompt('Paste agreement token to sign:')
    if (!token) return
    await signAgreement(token)
    setMessage('Agreement signed.')
  }

  return (
    <main>
      <header>
        <div className="logo">TronSync</div>
        <h1>E-Invoicing Customer Management</h1>
        <p>Manage customers, schedule meetings, and send NDA/partnership agreements.</p>
      </header>
      {message && <div className="toast">{message}</div>}
      <CustomerForm onCreate={handleCreate} />
      <CustomerTable customers={customers} onMeeting={handleMeeting} onAgreement={handleAgreement} />
      <button className="secondary" onClick={handleQuickSign}>Mark Agreement as Signed</button>
    </main>
  )
}
