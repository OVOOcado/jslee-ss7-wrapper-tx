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

package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.service.supplementary.SSForBSCode;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPSS_ForBS_CodeWrapper;


/**
 * TxMAPSS_ForBS_CodeWrapper.
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPSS_ForBS_CodeWrapper implements MAPSS_ForBS_CodeWrapper {

    /** The s s for bs code. */
    private final SSForBSCode sSForBSCode;

    /**
     * Instantiates a new tx maps s_ for b s_ code wrapper.
     *
     * @param sSForBSCode the s s for bs code
     */
    public TxMAPSS_ForBS_CodeWrapper(final SSForBSCode sSForBSCode) {
        this.sSForBSCode = sSForBSCode;
    }

    /**
     * Gets the tx ss for bs code.
     *
     * @return the tx ss for bs code
     */
    public SSForBSCode getTxSSForBSCode() {
        return sSForBSCode;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxMAPSS_ForBS_CodeWrapper [sSForBSCode=" + sSForBSCode + "]";
    }

}
