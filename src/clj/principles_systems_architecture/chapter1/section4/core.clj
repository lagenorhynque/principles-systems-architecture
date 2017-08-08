(ns principles-systems-architecture.chapter1.section4.core
  (:require [principles-systems-architecture.chapter1.section4.customer :as customer]
            [schema.core :as s]))

;;; CHAPTER 1: 小さくまとめてわかりやすくする
;;; 複雑さを閉じ込める

(defn execute1 []
  (let [cs1 (customer/customers)
        cs2 (-> cs1
                (customer/add (customer/->Customer "X"))
                (customer/add (customer/->Customer "Y"))
                (customer/add (customer/->Customer "Z")))
        cs3 (customer/remove-if-exist cs2 (customer/->Customer "Y"))]
    (println "cs1:" cs1)
    (println "cs2:" cs2)
    (println "cs3:" cs3)
    (println "(important-customers cs3):" (customer/important-customers cs3))
    (println "(as-list cs3):" (customer/as-list cs3))))

(defn -main [& args]
  (execute1))
