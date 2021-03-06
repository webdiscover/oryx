/*
 * Copyright (c) 2013, Cloudera, Inc. All Rights Reserved.
 *
 * Cloudera, Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the
 * License.
 */

package com.cloudera.oryx.common.iterator;

import com.google.common.base.Preconditions;

import java.util.Iterator;

/**
 * An {@link Iterable} that can provide an {@link Iterator} over an array.

 * @param <T> array value type
 * @author Sean Owen
 */
public final class ArrayIterable<T> implements Iterable<T> {

  private final T[] values;
  private final int from;
  private final int to;

  /**
   * @param values array to iterate over
   */
  public ArrayIterable(T[] values) {
    this(values, 0, values.length);
  }

  /**
   * @param values array to iterate over
   * @param from index to start iteration from (inclusive)
   * @param to index to stop iterating at (exclusive)
   */
  public ArrayIterable(T[] values, int from, int to) {
    Preconditions.checkArgument(from <= to);
    this.values = values;
    this.from = from;
    this.to = to;
  }

  @Override
  public Iterator<T> iterator() {
    return new ArrayIterator<>(values, from, to);
  }

}
