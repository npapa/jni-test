/**
 * @file   tiledb.h
 *
 * @section LICENSE
 *
 * The MIT License
 *
 * @copyright Copyright (c) 2017-2018 TileDB, Inc.
 * @copyright Copyright (c) 2016 MIT and Intel Corporation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @section DESCRIPTION
 *
 * This file declares the C API for TileDB.
 */

#ifndef TILEDB_OLD_H
#define TILEDB_OLD_H

#include <cstdint>
#include <cstdio>

#include "tiledb.h"

/* ********************************* */
/*               MACROS              */
/* ********************************* */

#ifdef __cplusplus
extern "C" {
#endif

/**@{*/
/** C Library export. */
#if (defined __GNUC__ && __GNUC__ >= 4) || defined __INTEL_COMPILER
#define TILEDB_EXPORT __attribute__((visibility("default")))
#elif defined _MSC_VER
#define TILEDB_EXPORT __declspec(dllexport)
#else
#define TILEDB_EXPORT
#pragma message("TILEDB_EXPORT is not defined for this compiler")
#endif
/**@}*/

#if (defined __GNUC__) || defined __INTEL_COMPILER
#define TILEDB_DEPRECATED __attribute__((deprecated, visibility("default")))
#elif defined _MSC_VER
#define TILEDB_DEPRECATED __declspec(deprecated)
#else
#define DEPRECATED
#pragma message("TILEDB_DEPRECATED is not defined for this compiler")
#endif



TILEDB_EXPORT int tiledb_dimension_get_domain_i(
    tiledb_ctx_t* ctx, const tiledb_dimension_t* dim, int** domain){
    return tiledb_dimension_get_domain(ctx, dim, (void**) domain);
    };

#undef TILEDB_EXPORT
#ifdef __cplusplus
}
#endif

#endif  // TILEDB_OLD_H
