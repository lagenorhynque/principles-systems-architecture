(ns lagenorhynque.principles-systems-architecture.chapter1.section2.core
  (:require
   [lagenorhynque.principles-systems-architecture.chapter1.section2.shipping-cost :as shipping-cost]
   [schema.core :as s]))

;;; CHAPTER 1: 小さくまとめてわかりやすくする
;;; プログラムの変更が楽になる書き方

(s/defn shipping-cost :- Long
  [base-price :- Long]
  (shipping-cost/amount base-price))

(s/defn tax-rate :- Double
  []
  1.08)

(defn execute1 []
  (let [quantity 3
        unit-price 5000
        base-price (* quantity unit-price)
        cost (shipping-cost base-price)
        item-price (-> (+ base-price cost)
                       (* (tax-rate))
                       long)]
    (println "item-price:" item-price)))

(defn -main [& args]
  (execute1))
