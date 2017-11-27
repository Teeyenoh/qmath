#pragma once

#if defined(_WIN32) || defined(_WIN64)
#if defined(_WIN64)
#define QLong _int64
#else
#define QLong _int32
#endif
#endif

#include <list>