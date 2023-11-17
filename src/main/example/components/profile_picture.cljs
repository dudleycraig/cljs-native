(ns example.components.profile-picture
  (:require ["react" :as r]
            ["react-native" :as rn :refer [View Text Image Button StyleSheet]]
            ["tailwind-rn" :as tailwind]

            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]

            [example.providers.app-provider :as app-provider]))

(defnc ProfilePicture [props]
  (let [tw (tailwind/useTailwind)]
    ($ Image
      {:source (js/require "../assets/images/profile.jpg")
       :style (. js/Object assign
                 (clj->js {:resizeMode "center" :width 100 :height 100})
                 (tw "border border-black rounded"))})))

