/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HaiDang
 */
public class Cart {

    private HashMap<Integer, Item> cart;

    public Cart() {
        cart = new HashMap<>();
    }

    public Cart(HashMap<Integer, Item> cart) {
        this.cart = cart;
    }

    public HashMap<Integer, Item> getCart() {
        return cart;
    }

    public void setCart(HashMap<Integer, Item> cart) {
        this.cart = cart;
    }

    // Thêm sản phẩm vào giỏ hàng
    public void plusToCart(int key, Item item) {
        boolean check = cart.containsKey(key);
        if (check) {
            int soLuongCu = item.getSoLuong();
            item.setSoLuong(soLuongCu + 1);
            cart.put(key, item);
        } else{
            cart.put(key, item);
        }
    }
 
    // Xóa 1 sp khỏi giỏ hàng
    public void SubTheCart(int key, Item item){
        boolean check = cart.containsKey(key);
        if (check){
            int soLuongCu = item.getSoLuong();
            if (soLuongCu <= 1) {
                cart.remove(key);
            }else{
                item.setSoLuong(soLuongCu - 1);
                cart.put(key, item);
            }
        }
    }
    
    // Xóa sản phẩm
    public void offTheCart(int key, Item item){
        cart.remove(key);
    }    
    
   
    // Tổng số tiền
    public Integer totalCart(){
        int count = 0;
        for (Map.Entry<Integer, Item> list : cart.entrySet()) {
            count += list.getValue().getSoLuong() 
                    * list.getValue().getSanPham().getGiaSanPham();
        }
        return count;
    }
}
