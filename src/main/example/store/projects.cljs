(ns example.store.projects
  (:require
   [clojure.spec.alpha :as s]
   [example.store.images] 
   [example.store.technologies]))

(def Projects {:odeko
               {:name "odeko"
                :title "Odeko"
                :description "eCommerce, both business to client and business to client, mobile applications."
                :responsibilities ["Initialization of expo (ios/android/web) b2b client."
                                   "Authentication/Authorization and models there of."]
                :technologies {:frontend [:clojurescript :react-native :helix]
                               :tools [:docker]}
                :images {:small [{:src "/images/employers/vbt/odeko/small/image-1.jpg" :alt "odeko thumbnail"}]
                         :large [{:src "/images/employers/vbt/odeko/large/image-animated.jpg" :alt "odeko animated"}
                                 {:src "/images/employers/vbt/odeko/large/image-1.jpg" :alt "login-1"}
                                 {:src "/images/employers/vbt/odeko/large/image-2.jpg" :alt "login-2"}
                                 {:src "/images/employers/vbt/odeko/large/image-3.jpg" :alt "home"}]}}})

(s/def ::key keyword?)
(s/def ::name string?)
(s/def ::title string?)
(s/def ::description string?)
(s/def ::responsibility string?)
(s/def ::responsibilities (s/coll-of ::responsibility))
(s/def ::frontend (s/coll-of :example.store.technologies/key))
(s/def ::backend (s/coll-of :example.store.technologies/key))
(s/def ::tools (s/coll-of :example.store.technologies/key))
(s/def ::technologies (s/keys :req-un []
                              :opt-un [::frontend ::backend ::tools]))
(s/def ::project (s/keys :req-un [::name ::title ::description ::responsibilities ::technologies]
                         :opt-un [:example.store.images/images]))
(s/def ::projects (s/map-of ::key ::project))

(comment
  (let [Project-1 {:name "project-1"
                   :title "Project-1 title"
                   :description "Project-1 description"
                   :responsibilities ["Project-1 Responsibilities-1"
                                      "Project-1 Responsibilities-2"]
                   :technologies {:frontend [:clojurescript :react-native :helix]
                                  :tools [:docker]}
                   :images {:small [{:src "/small-1.jpg" :alt "project#1 images small 1"}]
                            :large [{:src "/large-1.jpg" :alt "project#1 images large 1"}
                                    {:src "/large-2.jpg" :alt "project#1 images large 2"}
                                    {:src "/large-3.jpg" :alt "project#1 images large 3"}
                                    {:src "/large-4.jpg" :alt "project#1 images large 4"}]}}
        Projects {:project-1 Project-1}]
    (and
      (s/explain ::project Project-1)
      (s/explain ::projects Projects))))

