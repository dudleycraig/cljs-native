(ns za.org.functional.store.employers
  (:require
   [clojure.spec.alpha :as s]

   [za.org.functional.store.contracts]
   [za.org.functional.store.developer-roles]))

(def Employers
  [{:name "vbt"
    :title "Very Big Things"
    :description "Based in Florida, a majority developers worked from Croatia and Ukraine. The company primarily does media using Clojure/ClojureScript. "
    :contract :fixed-term
    :developer-role :fullstack-developer
    :duration {:from "2021-10-01" :to "2022-10-01"}
    :images {:small [{:src "/images/employers/vbt/small/image-1.jpg" :alt "vbt thumbnail"}]
             :large [{:src "/images/employers/vbt/large/image-animated.jpg" :alt "vbt animated"}
                     {:src "/images/employers/vbt/large/image-1.jpg" :alt "vbt image-1"}
                     {:src "/images/employers/vbt/large/image-2.jpg" :alt "vbt image-2"}
                     {:src "/images/employers/vbt/large/image-3.jpg" :alt "vbt image-3"}]}
    :projects [:odeko]}])

(s/def ::name string?)
(s/def ::title string?)
(s/def ::description string?)
(s/def ::contract :za.org.functional.store.contracts/key)
(s/def ::developer-role :za.org.functional.store.developer-roles/key)
(s/def ::from string?)
(s/def ::to string?)
(s/def ::duration (s/keys :from :to))
(s/def ::projects (s/coll-of :za.org.functional.store.projects/key))
(s/def ::employer (s/keys :req-un [::name 
                                   ::title 
                                   ::description 
                                   ::contract
                                   ::developer-role       
                                   ::duration]
                          :opt-un [:za.org.functional.store.images/images 
                                   ::projects]))
(s/def ::employers (s/coll-of ::employer))

(comment
  (let [Employer-1 {:name "vbt"
                    :title "Very Big Things"
                    :description "employer-1 description"
                    :contract :fixed-term
                    :developer-role :fullstack-developer
                    :duration {:from "2021-10-01" :to "2022-10-01"}
                    :images {:small [{:src "/small-1.jpg" :alt "employer-1 images small 1"}]
                             :large [{:src "/large-1.jpg" :alt "employer-1 images large 1"}
                                     {:src "/large-2.jpg" :alt "employer-1 images large 2"}
                                     {:src "/large-3.jpg" :alt "employer-1 images large 3"}
                                     {:src "/large-4.jpg" :alt "employer-1 images large 4"}]}
                    :projects [:odeko]}
        Employers [Employer-1]]
    (and
      (s/explain ::employer Employer-1)
      (s/explain ::employers Employers))))


