(ns principles-systems-architecture.chapter1.section4.customer
  (:require [schema.core :as s]))

(s/defrecord Customer
             [name :- s/Str])

(s/defrecord Customers
             [customers :- [Customer]])

(s/defn customers :- Customers
  ([]
   (->Customers []))
  ([cs :- [Customer]]
   (->Customers cs)))

(s/defn add :- Customers
  [cs :- Customers
   c :- Customer]
  (customers (conj (:customers cs) c)))

(s/defn remove-if-exist :- Customers
  [cs :- Customers
   c :- Customer]
  (customers (vec (remove #{c} (:customers cs)))))

(s/defn important-customers :- Customers
  [_ :- Customers]
  (customers [(->Customer "A")
              (->Customer "B")
              (->Customer "C")]))

(s/defn as-list :- [Customer]
  [cs :- Customers]
  (:customers cs))
