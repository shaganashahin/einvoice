export default function CustomerTable({ customers, onMeeting, onAgreement }) {
  return (
    <div className="panel">
      <h2>Customer Directory</h2>
      <table>
        <thead>
          <tr>
            <th>Company</th>
            <th>Contact</th>
            <th>Email</th>
            <th>Meeting</th>
            <th>Agreement</th>
          </tr>
        </thead>
        <tbody>
          {customers.map((customer) => (
            <tr key={customer.id}>
              <td>{customer.companyName}</td>
              <td>{customer.contactPerson}</td>
              <td>{customer.email}</td>
              <td>
                <button onClick={() => onMeeting(customer.id)}>Schedule</button>
              </td>
              <td className="agreement-actions">
                <button onClick={() => onAgreement(customer.id, 'NDA')}>Send NDA</button>
                <button onClick={() => onAgreement(customer.id, 'PARTNERSHIP')}>Send Partnership</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}
