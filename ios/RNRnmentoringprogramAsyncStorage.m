
#import "RNRnmentoringprogramAsyncStorage.h"

@interface RCT_EXTERN_MODULE(RNRnmentoringprogramAsyncStorage, NSObject)
RCT_EXTERN_METHOD(getItem:(NSString *)key resolve:(RCTPromiseResolveBlock)resolve
                  reject:(RCTPromiseRejectBlock)reject);
RCT_EXTERN_METHOD(setItem:(NSString *)key value:(NSString *)value resolve:(RCTPromiseResolveBlock)resolve
                  reject:(RCTPromiseRejectBlock)reject);
RCT_EXTERN_METHOD(getMultipleItems:(NSArray *)keys resolve:(RCTPromiseResolveBlock)resolve
                  reject:(RCTPromiseRejectBlock)reject)
RCT_EXTERN_METHOD(setMultipleItems:(NSArray *)keyValuePairs resolve:(RCTPromiseResolveBlock)resolve
                  reject:(RCTPromiseRejectBlock)reject)
@end
