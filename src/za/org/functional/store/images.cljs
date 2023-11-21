(ns za.org.functional.store.images
  (:require
   [clojure.spec.alpha :as s]))

(s/def ::src string?)
(s/def ::alt string?)
(s/def ::description string?)
(s/def ::image (s/keys :req-un [::src] 
                       :opt-un [::alt ::description]))
(s/def ::small (s/coll-of ::image))
(s/def ::medium (s/coll-of ::image))
(s/def ::large (s/coll-of ::image))
(s/def ::images (s/keys :opt-un [::small ::medium ::large]))

(comment
  (let [Image#1 {:src "http://test.com" :alt "Once was an Image" :description "An Image of a thousand words"}
        Image#2 {:src "http://test.com" :alt "Once was an Image"}
        Image#3 {:src "http://test.com" :description "An Image of a thousand words"}
        Image#4 {:src "http://test.com"}
        Images  {:small [Image#1 Image#2 Image#3 Image#4]
                 :large [Image#1 Image#2 Image#3 Image#4]}]
    (and
      (s/valid? ::image Image#1)
      (s/valid? ::images Images))))

