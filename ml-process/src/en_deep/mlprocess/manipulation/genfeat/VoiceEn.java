/*
 *  Copyright (c) 2010 Ondrej Dusek
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

package en_deep.mlprocess.manipulation.genfeat;

import en_deep.mlprocess.manipulation.StToArff;
import en_deep.mlprocess.manipulation.StToArff.StToArffConfig;
import java.util.Vector;

/**
 * This feature indicates the word's voice in English (as a verb), if applicable. It depends
 * on PTB tagset.
 * @author Ondrej Dusek
 */
public class VoiceEn extends Feature {


    /* METHODS */

    public VoiceEn(StToArffConfig config) {
        super(config);
    }

    @Override
    public String getHeader() {
        return StToArff.ATTRIBUTE + " Voice " + StToArff.CLASS + "{Infinite,Active,Passive,-}";
    }

    @Override
    public String generate(Vector<String[]> sentence, int wordNo, int predNo) {

        String wordPos = sentence.get(wordNo)[this.config.IDXI_POS];
        String headPos = null;
        int head = Integer.parseInt(sentence.get(wordNo)[this.config.IDXI_HEAD]);

        if (head > 0){
            headPos = sentence.get(head-1)[this.config.IDXI_POS];
        }

        // we need to deal with a verb
        if (wordPos.startsWith("VB") || wordPos.equals("MD")){

            if (!wordPos.equals("VBN") || headPos == null){
                if (wordPos.equals("VB")){ // infinite verb form
                    return "Infinite";
                }
                return "Active";
            }
            if (headPos.startsWith("VB")){ // VBN dependens on another verb form -> passive
                return "Passive";
            }
            return "Active";
        }
        // not a verb
        else {
            return "-";
        }
    }


}