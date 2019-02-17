//
//  RNRnmentoringprogramAsyncStorage.swift
//  RNRnmentoringprogramAsyncStorage
//
//  Created by Alex K on 2/13/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation

@objc(RNRnmentoringprogramAsyncStorage)
class RNRnmentoringprogramAsyncStorage: NSObject {
    
    func performInBackground(_ task: @escaping () -> Void) {
        DispatchQueue.global(qos: .userInteractive).async(execute: {
            task()
        })
    }
    
    @objc func getItem(_ key: String,
                       resolve: @escaping RCTPromiseResolveBlock,
                       reject: @escaping RCTPromiseRejectBlock){
        performInBackground({
            resolve(UserDefaults.standard.string(forKey: key))
        })
    }
    
    @objc func setItem(_ key: String, value: String,
                       resolve: @escaping RCTPromiseResolveBlock,
                       reject: @escaping RCTPromiseRejectBlock) {
        performInBackground({
            UserDefaults.standard.set(value, forKey: key)
            resolve(true)
        })
    }
    
    @objc func setMultipleItems(_ keyValuePairs: [[String]],
                                resolve: @escaping RCTPromiseResolveBlock,
                                reject: @escaping RCTPromiseRejectBlock) {
        performInBackground({
            keyValuePairs.forEach({ keyValuePair in
                UserDefaults.standard.set(keyValuePair[1], forKey: keyValuePair[0])
            })
            resolve(true)
        })
    }
    
    @objc func getMultipleItems(_ keys: [String],
                                resolve: @escaping RCTPromiseResolveBlock,
                                reject: @escaping RCTPromiseResolveBlock) {
        performInBackground({
            resolve(keys.map({ key in
                UserDefaults.standard.string(forKey: key)
            }))
        })
    }
}
