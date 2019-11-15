import React from 'react';
import renderer from 'react-test-renderer';

import GameUtils from '..\src\component\GameUtils.js';

describe('<GameUtils />', () => {
    it('should match the snapshot', () => {
      const component = renderer.create(<GameUtils />).toJSON();
      expect(component).toMatchSnapshot();
    });
  });