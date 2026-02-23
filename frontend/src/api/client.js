const API_BASE = 'http://localhost:8080/api'

export async function getCustomers() {
  const response = await fetch(`${API_BASE}/customers`)
  return response.json()
}

export async function createCustomer(payload) {
  const response = await fetch(`${API_BASE}/customers`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(payload)
  })
  return response.json()
}

export async function scheduleMeeting(customerId, payload) {
  const response = await fetch(`${API_BASE}/customers/${customerId}/meetings`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(payload)
  })
  return response.json()
}

export async function sendAgreement(customerId, type) {
  const response = await fetch(`${API_BASE}/customers/${customerId}/agreements`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ type })
  })
  return response.json()
}

export async function signAgreement(token) {
  const response = await fetch(`${API_BASE}/agreements/sign/${token}`, { method: 'POST' })
  return response.json()
}
