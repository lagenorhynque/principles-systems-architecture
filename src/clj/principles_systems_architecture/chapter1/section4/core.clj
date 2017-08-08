(ns principles-systems-architecture.chapter1.section4.core
  (:require [principles-systems-architecture.chapter1.section4.customer :as customer]
            [principles-systems-architecture.chapter1.section4.customers :as customers]
            [schema.core :as s]))

;;; CHAPTER 1: 小さくまとめてわかりやすくする
;;; 複雑さを閉じ込める

(defn execute1 []
  (let [cs1 (customers/customers)
        cs2 (-> cs1
                (customers/add (customer/customer "X"))
                (customers/add (customer/customer "Y"))
                (customers/add (customer/customer "Z")))
        cs3 (customers/remove-if-exist cs2 (customer/customer "Y"))]
    (println "cs1:" cs1)
    (println "cs2:" cs2)
    (println "cs3:" cs3)
    (println "(important-customers cs3):" (customers/important-customers cs3))
    (println "(as-list cs3):" (customers/as-list cs3))))

(defn -main [& args]
  (execute1))
