import { Link } from 'react-router-dom';

function OrderSummary() {
    return (
        <div className="order-summary-container">
             <div className="order-summary-content">
               <div>
               <span className="amount-selected-container">
                    <strong className="amount-selected">2</strong>
                    PEDIDOS SELECIONADOS
                </span>
                <span className="order-summary-total">
                    <strong className="amount-selected">R$ 50,00</strong>
                    VALOR TOTAL
                </span>
               </div>
               <button className="order-summary-make-order">
                   FAZER PEDIDO
               </button>
            </div>
        </div>
    );
}

export default OrderSummary;