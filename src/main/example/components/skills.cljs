(ns example.components.skills
  (:require ["react" :as r]
            ["react-native" :as rn :refer [View Text Image StyleSheet Button]]
            ["tailwind-rn" :as tailwind]

            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]

            [example.store.technologies :refer [technologies]]))

(defnc Skill [{:keys [technology] :as props}] 
  (let [tw (tailwind/useTailwind)]
    ($ View {:style (tw "flex flex-row flex-no-wrap justify-top content-left w-full h-8")}
       ($ View {:style (tw "w-64 h-full")}
          ($ Text {:style (tw "")} (:name technology)))
       ($ View {:style (tw "")}
          ($ Text {:style (tw "")} (:title technology)))
       ($ View {:style (tw "")}
          ($ Text {:style (tw "")} (:description technology)))
       ($ View {:style (tw "")}
          ($ Text {:style (tw "")} (:months-used technology)))
       ($ View {:style (tw "")}
          ($ Text {:style (tw "")} (:proficiency technology)))
       ($ View {:style (tw "")}
          ($ Text {:style (tw "")} (:current technology)))
       ($ View {:style (tw "")}
          ($ Text {:style (tw "")} (:usage technology))))))

(defnc Skills [props]
  (map
   (fn [[technology-key technology]]
     ($ Skill {:technology technology :key (str "key-" (name technology-key))}))
   technologies))

