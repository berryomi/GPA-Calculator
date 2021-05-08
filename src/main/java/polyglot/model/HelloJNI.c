#include <jni.h>        // JNI header provided by JDK
#include <stdio.h>      // C Standard IO Header
#include "polyglot_model_HelloJNI.h"   // Generated

JNIEXPORT jdouble JNICALL Java_polyglot_model_HelloJNI_calculateInC(JNIEnv *env, jobject thisObj, jint currentUnits, jdouble currentGPA, jint termCredit, jdouble termGPA, jint totalCredit) {
    printf("Hello from C!\n");

    return ((currentUnits * currentGPA) + (termCredit * termGPA) ) / totalCredit;
}