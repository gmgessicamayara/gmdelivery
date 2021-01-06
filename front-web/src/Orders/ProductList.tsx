import ProductCard from './ProductCard';
import './styles.css';

function ProductList() {
    return (
       <div className="orders-list-container">
             <div className="orders-list-items">
                <ProductCard />
                <ProductCard />
                <ProductCard />
                <ProductCard />
                <ProductCard />
                <ProductCard />
                <ProductCard />
                <ProductCard />
                <ProductCard />
             </div>
       </div>
    );
}

export default ProductList;