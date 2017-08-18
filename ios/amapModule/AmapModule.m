#import <Foundation/Foundation.h>
#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(AmapLocation, NSObject)
    RCT_EXTERN_METHOD(startLocation)
    RCT_EXTERN_METHOD(stopLocation)
@end
