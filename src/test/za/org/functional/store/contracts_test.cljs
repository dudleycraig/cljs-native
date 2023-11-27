(ns za.org.functional.store.contracts-test
  (:require [cljs.test :as t :include-macros true]
            [za.org.functional.app :as app]
            [clojure.spec.alpha :as s]
            [za.org.functional.store.contracts :refer [data]]))

(t/run-all-tests)

(def invalid-contract-1 {})
(def invalid-contract-2 {:description "invalid-contract-2 description"})
(def invalid-contract-3 {:name "invalid-contract-3 name"})

(def valid-contract-1 {:name "valid-contract-1 name" :description "valid-contract-1 description"})
(def valid-contract-2 {:name "valid-contract-2 name" :description "valid-contract-2 description"})
(def valid-contract-3 {:name "valid-contract-3 name" :description "valid-contract-3 description"})

(def invalid-contracts-1 {:contract-1 invalid-contract-1 :contract-2 valid-contract-2 :contract-3 valid-contract-3})
(def invalid-contracts-2 {:contract-1 valid-contract-1 :contract-2 invalid-contract-2 :contract-3 valid-contract-3})
(def invalid-contracts-3 {:contract-1 valid-contract-1 :contract-2 valid-contract-2 :contract-3 invalid-contract-3})

(def valid-contracts-1 {:contract-1 valid-contract-1 :contract-2 valid-contract-1 :contract-3 valid-contract-1})

(deftest contracts-test
  (t/testing "specs conform to test data"
    (t/is
     (and
       (not
        (and
          (s/valid? :za.org.functional.store.contracts/contract invalid-contract-1)
          (s/valid? :za.org.functional.store.contracts/contract invalid-contract-2)
          (s/valid? :za.org.functional.store.contracts/contract invalid-contract-3)
          (s/valid? :za.org.functional.store.contracts/contracts invalid-contracts-1)
          (s/valid? :za.org.functional.store.contracts/contracts invalid-contracts-2)
          (s/valid? :za.org.functional.store.contracts/contracts invalid-contracts-3)))
       (and
         (s/valid? :za.org.functional.store.contracts/contract valid-contract-1)
         (s/valid? :za.org.functional.store.contracts/contracts valid-contracts-1)))))

  (t/testing "data conforms to specs"
    (t/is
     (s/valid? :za.org.functional.store.contracts/contracts data))))

