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

import org.mobicents.protocols.ss7.map.api.primitives.CellGlobalIdOrServiceAreaIdOrLAI;
import pl.ovoo.jslee.ss7.wrapper.map.args.CellGlobalIdWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPCellGlobalIdOrServiceAreaIdOrLAIWrapper;

/**
 * TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper implements MAPCellGlobalIdOrServiceAreaIdOrLAIWrapper {

    private transient CellGlobalIdWrapper cellGlobalIdWrapper = null;

    private final CellGlobalIdOrServiceAreaIdOrLAI cellGlobalIdOrServiceAreaIdOrLAI;

    public TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper(
            final CellGlobalIdOrServiceAreaIdOrLAI cellGlobalIdOrServiceAreaIdOrLAI) {
        this.cellGlobalIdOrServiceAreaIdOrLAI = cellGlobalIdOrServiceAreaIdOrLAI;
    }

    @Override
    public boolean isCellGlobalIdOrServiceAreaIdFixedLengthChosen() {
        return cellGlobalIdOrServiceAreaIdOrLAI.getCellGlobalIdOrServiceAreaIdFixedLength() != null
                && cellGlobalIdOrServiceAreaIdOrLAI.getLAIFixedLength() == null;
    }

    @Override
    public CellGlobalIdWrapper getCellGlobalIdOrServiceAreaIdFixedLength() {
        if (this.cellGlobalIdWrapper == null
                && this.cellGlobalIdOrServiceAreaIdOrLAI.getCellGlobalIdOrServiceAreaIdFixedLength() != null) {
            this.cellGlobalIdWrapper = new TxCellGlobalIdWrapper(
                    cellGlobalIdOrServiceAreaIdOrLAI.getCellGlobalIdOrServiceAreaIdFixedLength());
        }
        return this.cellGlobalIdWrapper;
    }

    public CellGlobalIdOrServiceAreaIdOrLAI getTxCellGlobalIdOrServiceAreaIdOrLAI() {
        return cellGlobalIdOrServiceAreaIdOrLAI;
    }

    @Override
    public String toString() {
        return "TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper [cellGlobalIdOrServiceAreaIdOrLAI="
                + cellGlobalIdOrServiceAreaIdOrLAI + "]";
    }

}
