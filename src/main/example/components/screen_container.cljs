(ns example.components.screen-container
  (:require ["react" :as r]
            ["react-native" :as rn :refer [View Text Image Button StyleSheet]]
            ["tailwind-rn" :as tailwind]

            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]

            [example.providers.app-provider :as app-provider]))

(defnc ScreenContainer [{:keys [children] :as props}]
  (let [tw (tailwind/useTailwind)]
    ($ View 
       {:style (tw "flex flex-col flex-no-wrap justify-top content-center items-center w-full h-full p-2")}
       children)))

