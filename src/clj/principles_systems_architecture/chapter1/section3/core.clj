(ns principles-systems-architecture.chapter1.section3.core
  (:require [principles-systems-architecture.chapter1.section3.money :as money]
            [principles-systems-architecture.chapter1.section3.quantity :as quantity]
            [schema.core :as s])
  (:import (principles_systems_architecture.chapter1.section3.money Money)
           (principles_systems_architecture.chapter1.section3.quantity Quantity)))

;;; CHAPTER 1: 小さくまとめてわかりやすくする
;;; 小さなクラスでわかりやすく安全に

(defn execute1 []
  (let [q (quantity/quantity 30)]
    (println "q:" q)
    (println "(can-add? q (quantity 70)):" (quantity/can-add? q (quantity/quantity 70)))
    (println "(add q (quantity 70)):" (quantity/add q (quantity/quantity 70)))
    (println "(can-add? q (quantity 71)):" (quantity/can-add? q (quantity/quantity 71)))))

(defn execute2 []
  (let [base-price (money/money 3000)
        discounted (money/minus base-price (money/money 100))
        option (money/money 1000)]
    (println "base-price:" base-price)
    (println "discounted:" discounted)
    (println "option:" option)))

(s/defn discount :- Money
  [unit-price :- Money
   quantity :- Quantity]
  (money/multiply (-> (:value unit-price)
                      (* 0.8)
                      long
                      money/money)
                  quantity))

(s/defn amount :- Money
  [unit-price :- Money
   quantity :- Quantity]
  (if (:discountable? quantity)
    (discount unit-price quantity)
    (money/multiply unit-price quantity)))

(defn execute3 []
  (let [unit-price (money/money 2500)
        quantity (quantity/quantity 10)
        amount' (amount unit-price quantity)]
    (println "unit-price:" unit-price)
    (println "quantity:" quantity)
    (println "amount:" amount')))

(defn -main [& args]
  (execute1)
  (execute2)
  (execute3))
