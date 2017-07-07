/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.ss7.wrapper.map.tx.args;

import java.util.Arrays;

import pl.ovoo.ss7.wrapper.map.args.MAPCallForwardingDataWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPExt_ForwFeatureWrapper;

/**
 * TxMAPCallForwardingDataWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPCallForwardingDataWrapper implements MAPCallForwardingDataWrapper{
	
    private MAPExt_ForwFeatureWrapper[] mAPExt_ForwFeatureWrappers;

    public TxMAPCallForwardingDataWrapper(final MAPExt_ForwFeatureWrapper[] mAPExt_ForwFeatureWrappers) {
        this.mAPExt_ForwFeatureWrappers = mAPExt_ForwFeatureWrappers;
    }
        
    @Override
    public MAPExt_ForwFeatureWrapper[] getForwardingFeatureList(){
    	return mAPExt_ForwFeatureWrappers;
    }

    @Override
    public String toString() {
        return "TxMAPCallForwardingDataWrapper [mAPExt_ForwFeatureWrappers="
                + Arrays.toString(mAPExt_ForwFeatureWrappers) + "]";
    }
    
}
