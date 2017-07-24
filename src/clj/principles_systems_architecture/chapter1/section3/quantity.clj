(ns principles-systems-architecture.chapter1.section3.quantity
  (:require [schema.core :as s]))

(s/def minimum :- Long
  1)

(s/def maximum :- Long
  100)

(s/def minimum-for-discount :- Long
  10)

(s/defrecord Quantity
    [value :- Long
     discountable? :- s/Bool])

(s/defn quantity :- Quantity
  [value :- Long]
  {:pre [(<= minimum value maximum)]}
  (->Quantity value
              (>= value minimum-for-discount)))

(s/defn ^:private add-value :- Long
  [this :- Quantity
   other :- Quantity]
  (+ (:value this) (:value other)))

(s/defn can-add? :- s/Bool
  [this :- Quantity
   other :- Quantity]
  (let [added (add-value this other)]
    (<= added maximum)))

(s/defn add :- Quantity
  [this :- Quantity
   other :- Quantity]
  {:pre [(can-add? this other)]}
  (let [added (add-value this other)]
    (quantity added)))
