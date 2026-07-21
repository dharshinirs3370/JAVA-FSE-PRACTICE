import React, { useState } from 'react';

function CurrencyConvertor() {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  const handleSubmit = () => {
    const convertedAmount = amount * 80;
    alert(`Converting to  ${currency} Amount is ${convertedAmount}`);
  };

  return (
    <div>
      <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>
      <div>
        <label>Amount: </label>
        <input type="text" value={amount} onChange={(e) => setAmount(e.target.value)} />
      </div>
      <div>
        <label>Currency: </label>
        <input type="text" value={currency} onChange={(e) => setCurrency(e.target.value)} />
      </div>
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}

export default CurrencyConvertor;
