/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.saddleback.sraven0.gdxbreakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author sraven0
 */
public class MenuScreen implements Screen {

    Texture img;

    BreakoutGame game;

    Sprite logo;

    MenuScreen(BreakoutGame game) {
        this.game = game;
        img = new Texture("badlogic.jpg");
        logo = new Sprite(img);
        logo.setPosition(
                Gdx.graphics.getWidth() / 2 - logo.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - logo.getHeight() / 2);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        game.batch.draw(logo, logo.getX(), logo.getY());

        game.font.setColor(1, 0, 0, 1);
        game.font.draw(game.batch, "Welcome to Breakout!!! ",
                logo.getX(), logo.getY() + logo.getHeight() + 50);
        game.font.draw(game.batch, "Tap anywhere to begin!",
                logo.getX(), logo.getY() - 50);

        game.batch.end();

        if (Gdx.input.justTouched() || Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.setScreen(new GameScreen(game));
            dispose();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        img.dispose();
    }

}
