(ns principles-systems-architecture.chapter1.section2.shipping-cost
  (:require [schema.core :as s]))

(s/def minimum-for-free :- Long
  3000)

(s/def cost :- Long
  500)

(s/defn amount :- Long
  [base-price :- Long]
  (if (< base-price minimum-for-free)
    cost
    0))
