(ns lagenorhynque.principles-systems-architecture.chapter1.section4.customers
  (:require
   [lagenorhynque.principles-systems-architecture.chapter1.section4.customer :as customer]
   [schema.core :as s])
  (:import
   (lagenorhynque.principles_systems_architecture.chapter1.section4.customer
    Customer)))

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
  (customers [(customer/customer "A")
              (customer/customer "B")
              (customer/customer "C")]))

(s/defn as-list :- [Customer]
  [cs :- Customers]
  (:customers cs))
