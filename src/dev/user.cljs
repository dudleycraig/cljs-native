(ns user
  (:require [cljs.test]
            [za.org.functional.store.contracts-test]
            [za.org.functional.store.developer_roles-test]
            [za.org.functional.store.employers-test]
            [za.org.functional.store.icons-test]
            [za.org.functional.store.images-test]
            [za.org.functional.store.projects-test]
            [za.org.functional.store.technologies-test]))

(comment
  (cljs.test/run-all-tests)
  (cljs.test/run-all-tests #"za.org.functional.*-test"))

