(ns example.components.main-header
  (:require ["react" :as r]
            ["react-native" :as rn :refer [View Text Image StyleSheet Button]]
            ["tailwind-rn" :as tailwind]
 
            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]))

(defnc MainHeader [{:keys [navigation route options] :as props}]
  (let [tw (tailwind/useTailwind)]
    ($ View
      {:style (tw "flex flex-row flex-no-wrap justify-center content-center items-center w-full h-16 border-b border-solid border-b-black")}
      ($ Text {:style (tw "")} "(")
      ($ Text {:style (tw "text-xl font-bold mr-1")} "𝑓")
      ($ Text (. options -title))
      ($ Text {:style (tw "")} ")"))))

