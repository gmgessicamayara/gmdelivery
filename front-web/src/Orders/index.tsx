import './styles.css';
import StepsHeader from './StepsHeader';
import ProductList from './ProductList';
import { useEffect, useState } from 'react';
import { OrderLocationData, Product } from './types';
import { fetchProducts } from '../api';
import OrderLocation from './OrderLocation';
import OrderSummary from './OrderSummary';
import Footer from '../Footer';
import { checkIsSelected } from './helpers';

function Orders() {

    const [selectedProducts, setSelectedProducts] = useState<Product[]>([]);
    const [products, setProducts] = useState<Product[]>([]);
    const [orderLocation, setOrderLocation] =  useState<OrderLocationData>();

    useEffect( () => {
       fetchProducts()
       .then(response => setProducts(response.data))
       .catch(error => console.log(error));
    }, []);


    const handleSelectProduct = (product: Product) => {
    
        const isAlreadySelected = checkIsSelected(selectedProducts, product)
      
        if (isAlreadySelected) {
          const selected = selectedProducts.filter(item => item.id !== product.id);
          setSelectedProducts(selected);
        } else {
          setSelectedProducts(previous => [...previous, product]);
        }
      }

    return (
       <>
        <div className="orders-container">
            <StepsHeader/>
            <ProductList
             products={products}
             onSelectProduct={handleSelectProduct}
             selectedProducts={selectedProducts}/>
            <OrderLocation onChangeLocation={location => setOrderLocation(location)}/>
            <OrderSummary/>
        </div>
        <Footer/>
       </>
    );
}
export default Orders;