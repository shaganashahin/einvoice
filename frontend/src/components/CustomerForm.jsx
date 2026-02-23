import { useState } from 'react'

const initialState = {
  companyName: '',
  contactPerson: '',
  email: '',
  phone: '',
  address: '',
  notes: ''
}

export default function CustomerForm({ onCreate }) {
  const [form, setForm] = useState(initialState)

  function handleChange(event) {
    setForm((prev) => ({ ...prev, [event.target.name]: event.target.value }))
  }

  async function handleSubmit(event) {
    event.preventDefault()
    await onCreate(form)
    setForm(initialState)
  }

  return (
    <form className="panel" onSubmit={handleSubmit}>
      <h2>Add Customer</h2>
      <div className="grid">
        <input name="companyName" value={form.companyName} onChange={handleChange} placeholder="Company name" required />
        <input name="contactPerson" value={form.contactPerson} onChange={handleChange} placeholder="Contact person" required />
        <input name="email" value={form.email} onChange={handleChange} placeholder="Email" type="email" required />
        <input name="phone" value={form.phone} onChange={handleChange} placeholder="Phone" />
        <input name="address" value={form.address} onChange={handleChange} placeholder="Address" />
        <input name="notes" value={form.notes} onChange={handleChange} placeholder="Notes" />
      </div>
      <button type="submit">Save Customer</button>
    </form>
  )
}
