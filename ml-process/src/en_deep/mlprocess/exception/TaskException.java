/*
 *  Copyright (c) 2009 Ondrej Dusek
 *  All rights reserved.
 * 
 *  Redistribution and use in source and binary forms, with or without modification, 
 *  are permitted provided that the following conditions are met:
 *  Redistributions of source code must retain the above copyright notice, this list 
 *  of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright notice, this 
 *  list of conditions and the following disclaimer in the documentation and/or other 
 *  materials provided with the distribution.
 *  Neither the name of Ondrej Dusek nor the names of their contributors may be
 *  used to endorse or promote products derived from this software without specific 
 *  prior written permission.
 * 
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 *  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
 *  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, 
 *  BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
 *  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
 *  OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED 
 *  OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package en_deep.mlprocess.exception;

/**
 * The exception class for all run-time task errors.
 * @author Ondrej Dusek
 */
public class TaskException extends GeneralException {

    /* CONSTANTS */

    /** Error message: "Wrong number of outputs." */
    public static final int ERR_WRONG_NUM_OUTPUTS = 1;
    /** Error message: "Wrong number of inputs." */
    public static final int ERR_WRONG_NUM_INPUTS = 2;


    /* METHODS */

    /**
     * Creates a new {@link Task} exception with the given code, according
     * to the in-class constants.
     *
     * @param code the exception code
     */
    public TaskException(int code){
        super(code);
    }

    /**
     * Returns the error message according to the error code.
     * @return the appropriate error message
     */
    @Override
    public String getErrorMessage() {

        switch(this.code){
            case ERR_OK:
                return "No error.";
            case ERR_WRONG_NUM_OUTPUTS:
                return "Wrong number of outputs.";
            case ERR_WRONG_NUM_INPUTS:
                return "Wrong number of inputs.";
            default:
                return "Unknown error.";
        }
    }

}