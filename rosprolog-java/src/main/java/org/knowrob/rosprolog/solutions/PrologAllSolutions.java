/* 
 * Copyright (c) 2010, Lorenz Moesenlechner
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of Willow Garage, Inc. nor the names of its
 *       contributors may be used to endorse or promote products derived from
 *       this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.knowrob.rosprolog.solutions;

import java.util.Map;

import org.knowrob.rosprolog.query.ThreadedQuery;

import org.jpl7.Term;

public final class PrologAllSolutions implements PrologSolutions {

  private int currentIndex = 0;
  Map<String, Term>[] solutions = null;
  ThreadedQuery query = null;
  
  public PrologAllSolutions(ThreadedQuery query) throws Exception {
	  this.query = query;
  }
  
  private Map<String, Term>[] getSolutions() throws Exception {
	  // Compute solutions
	  if(solutions == null) {
		  solutions = query.allSolutions();
		  query.close();
		  query = null;
	  }
	  return solutions;
  }
  
  @Override
  public void close() throws Exception {
    // This method doesn't need to do anything here. We already closed the query. 
  }  
  
  @Override
  public void reset() throws Exception {
    currentIndex = 0;
  }

  @Override
  public Map<String, Term> nextSolution() throws Exception {
    Map<String, Term> result = getSolutions()[currentIndex];
    currentIndex++;
    return result;
  }

  @Override
  public boolean hasMoreSolutions() throws Exception {
    return currentIndex < getSolutions().length;
  }
}
